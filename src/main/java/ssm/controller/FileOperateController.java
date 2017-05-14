package ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ssm.model.BaseResponse;
import ssm.model.request.BaseRequest;
import ssm.utils.SecurityUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by hongcheng on 17/5/7.
 */

@Controller
@RequestMapping("/file")
public class FileOperateController {

    private Logger log = Logger.getLogger(FileOperateController.class.getName());

    @ResponseBody
    @RequestMapping(value = "/operate", method = RequestMethod.POST)
    public BaseResponse<Boolean> upload(MultipartFile file, HttpServletRequest request)
    {
        log.info("upload");
        boolean result = false;

        String path = request.getSession().getServletContext().getRealPath("upload");
        log.info("upload path : " + path);

        if(file != null)
        {
            String fileName = file.getOriginalFilename();
            log.info("upload : " + fileName);
            File dir = new File(path,fileName);
            if(!dir.exists()){
                dir.mkdirs();
            }
            //MultipartFile自带的解析方法
            try {
                log.info("transferTo : " + fileName);
                file.transferTo(dir);
                result = true;
            } catch (IOException e) {
                log.info("IOException", e);
            }
        }

        return new BaseResponse<Boolean>(result);
    }

    @RequestMapping(value = "/operate", method = RequestMethod.GET)
    public void download(HttpServletRequest request, HttpServletResponse response, @RequestParam BaseRequest<String> baseRequest)
    {
        String jsonStr = SecurityUtils.decodeBase64(baseRequest.getData());
        log.info("download : " + jsonStr);
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        String tempName = jsonObject.getString("fileName");

        log.info("download : " + tempName);

        try {
            String fileName = request.getSession().getServletContext().getRealPath("upload/")+ tempName;

            log.info("download : " + fileName);

            File file = new File(fileName);

            // 如果文件不存在
            if (!file.exists()) {
                request.setAttribute("message", "您要下载的资源已被删除！！");
                log.info("您要下载的资源已被删除！！");
                return;
            }
            //获取输入流
            InputStream bis = new BufferedInputStream(new FileInputStream(file));

            //假如以中文名下载的话
            String filename = "下载文件.txt";
            filename = URLEncoder.encode(filename,"UTF-8");

            //设置文件下载头
            response.addHeader("Content-Disposition", "attachment;filename=" + filename);
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            int len = 0;
            byte buffer[] = new byte[1024];
            while((len = bis.read()) != -1){
                out.write(buffer, 0, len);
                out.flush();
            }
            out.close();
        } catch (UnsupportedEncodingException e) {
            log.info("UnsupportedEncodingException", e);
        } catch (IOException e) {
            log.info("IOException", e);
        }
    }
}

