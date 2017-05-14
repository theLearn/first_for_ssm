package ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ssm.model.BaseResponse;
import ssm.model.Card;
import ssm.model.CardDetail;
import ssm.model.request.BaseRequest;
import ssm.service.CardService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by hongcheng on 17/4/19.
 */
@Controller
@RequestMapping("/card")
public class CardController {

    private Logger log = Logger.getLogger(CardController.class);

    @Resource
    private CardService cardService;

    @ResponseBody
    @RequestMapping("/cards")
    public BaseResponse<List<Card>> getCard(HttpServletRequest request, Model model){
        log.info("get all card info");
        List<Card> cardList = cardService.getAllCard();
        log.info("find finish :" + cardList.toString());
//        model.addAttribute("cardList",cardList);
        return new BaseResponse<List<Card>>(cardList);
    }

    @ResponseBody
    @RequestMapping(value = "/cardDetail", method = RequestMethod.GET)
    public BaseResponse<List<CardDetail>> getCardDetail(@RequestParam String type, Model model){
        log.info("get card detail info by type");
        List<CardDetail> list = cardService.getCardDetailByType(type);
        log.info("find finish :" + list.toString());
//        model.addAttribute("cardList",cardList);
        return new BaseResponse<List<CardDetail>>(list);
    }

    @ResponseBody
    @RequestMapping(value = "/cardDetail", method = RequestMethod.POST)
    public BaseResponse<Boolean> insertCardDetail(@Valid @RequestBody BaseRequest<CardDetail> baseRequest, Model model){
        log.info("insertCardDetail");
        boolean result = cardService.insertCardDetail(baseRequest.getData());
        log.info("insertCardDetail finish :" + result);
        return new BaseResponse<Boolean>(result);
    }

    @ResponseBody
    @RequestMapping(value = "/cardDetail", method = RequestMethod.DELETE)
    public BaseResponse<Boolean> delCardDetail(@RequestBody BaseRequest<CardDetail> baseRequest, Model model){
        log.info("delCardDetail : " + baseRequest.getData().getId());
        boolean result = cardService.deleteCardDetailById(baseRequest.getData().getId());
        log.info("delCardDetail finish :" + result);
        return new BaseResponse<Boolean>(result);
    }

    @ResponseBody
    @RequestMapping(value = "/cardDetail", method = RequestMethod.PUT)
    public BaseResponse<Boolean> updateCardDetail(@RequestBody BaseRequest<CardDetail> baseRequest, Model model){
        log.info("updateCardDetail");
        boolean result = cardService.updateCardDetailByType(baseRequest.getData());
        log.info("updateCardDetail finish :" + result);
        return new BaseResponse<Boolean>(result);
    }

}
