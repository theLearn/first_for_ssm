package ssm.model;

/**
 * Created by hongcheng on 17/5/7.
 */
public class FileOperate {

    private String fileName;
    private String clientPath;
    private String serverPath;
    private long size;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getClientPath() {
        return clientPath;
    }

    public void setClientPath(String clientPath) {
        this.clientPath = clientPath;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public FileOperate(String fileName, String clientPath, String serverPath, long size) {
        this.fileName = fileName;
        this.clientPath = clientPath;
        this.serverPath = serverPath;
        this.size = size;
    }

    @Override
    public String toString() {
        return "FileOperate{" +
                "fileName='" + fileName + '\'' +
                ", clientPath='" + clientPath + '\'' +
                ", serverPath='" + serverPath + '\'' +
                ", size=" + size +
                '}';
    }

    public FileOperate(){}

}
