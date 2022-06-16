package hello.core.lifecycle;

public class NetworkClient {
//public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
//        connect();
//        call("초기화 연결 메세지");
    }

    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message = " + message);
    }

    public void disConnect() {
        System.out.println("close : " + url);
    }

    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    public void close() {
        System.out.println("NetworkClient.close");
        disConnect();
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결 메세지");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }
}
