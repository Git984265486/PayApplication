package com.example.ConfigPay;

/**
 * 阿里支付配置
 * */

public class AlipayConfig {

    //商户APPID
    public static String APPID = "2016102500755882";

    //商户私钥
    public static String RSA_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCPI36Wjbux3CZY/sjMzwGIWX0A" +
            "Zy9hgaNMEVPcIbMS92bEZHYAxdV5j8F6ofGVk5b5pGCqzz3qloGZrCkmWtQ0Njsf8Sg0rFdbBxT9ZkOj8ogzJ+uDNYEJDOAeHz5o1EsYTGx" +
            "g5zsX2tvMyAeIpw0AbchAJCEtmZdaT57UdA5z2KOPgJRKcMqo44UOmse9vYgz1W/B3MfXoL+DvVPUtU/5BmkgBIh2YYpr3Pb6nXWZursV6Q" +
            "wi5JJzo84aUxhhkty0hrCE47Y0fyQnNuqxrrGomyL4XaesteI6gBeGvsIdmpEBztZP2UYVdPvjo/M7i2BubzxaE7AhIzqDnCzfJ+bJAgMBA" +
            "AECggEAHElAX9IccFZ4AYg/+DFENUSx7h12AIfU1FhsQQkr0Siw10ifBSITQJWG/4v3KL7ky+qO69JOgwhBDjQ2YYz7eGHrJzHJ5zbTgHqS" +
            "zEykO0bXYXyXDvPIzxgLRgiYlbC2MlQP6spnJBys6PfyfS+94wLO2tYI9HDwtvkbAxL4NC4komKBn5XH4dvy/H9GauA9dafq9OX97v/LyQv" +
            "HugfcfkCN7fdlgTPIIpzu7bF5NCOVNWZ/Zxuv4ykwzNMI30W7nEPhwhfPvGjb9/jYpno/S4uM3ubNK34ULbc5G2nJudBr4GIJiOO+M/HLx9" +
            "Fm/HkHCPBlW4Jchjd7eah5TvdEAQKBgQDP2Y5K+EJGHNjut5dZdzlrcvSxIEacblJ8PlR5+/nV28VfuRItZ/1vXT/uRrUvCoBiV/mCsu6dW" +
            "uokH7SDMaWgeDg8LMfYEzKynSRFooLRxJoHLLPOcgDFdbSLKetFIPOHVYJO44beVQHD8fKhESz4PLn7dGAfU6aJomRmCYQLSQKBgQCwTEUw" +
            "MhKJ2gZXKAXD0r+ksR3FwDnmwun9cCdtY8zNWZ73DFlU23xfZyXKNR1zTKhShAZU9tkE1X8svHTDHoUbJV4Cr3yXEGLfEhJ5bXD73WKwac3" +
            "w+7SqC9Q/ywxGiYcUuf/BnjpEpu5fB94On/EG9j2tndrIRtXdeI25NN1/gQKBgGU6QZDFpBFdj1GD3JRX+oEYNY/mdj1NhaK5AI+AZsb/B/" +
            "t8uRugH9ATDEXR7gABD1HWItDCsG+2jX4WauXSUiX7Jvg3nwTfJLvUyIuZgDkFlTaVUOTkpPeGQe3c9pZuW+y3eoVNTqwNnpR9y3siUFJ90" +
            "N5kaUQYi21Qx7DiRYrxAoGASbtMQHDgofimKDNb3d85OVa93eOcE6+3DsCmLLDNiaCOxEHM5pl49al8+4mlTIBl8US4JTar4sKrknkq2CPe" +
            "hVDmdXcRQ1ieES9MvK4Rz7RyPtexQrTyhR+3YAq6kpGYBgoYNdDIC8hI70OqEjHAKyo293KKerJtZVey5h9+94ECgYAm0ayrywg4PkUNYNg" +
            "GQb6Ix+6UuCqBn1lfMrKFrUuPilpbyB4W48k2VO9KF6YFdGxnNlHRn7ZyIzphPOk87tibOhKYHz/inkgPYEnxk6aCJXZhj1bSJCJ54XMjld" +
            "sUUFif4RFW/pYNN4g1OQ0IGEbM0FZRweQsmU5uXv3jRxQ68Q==";

    //支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2dC35KybJ9s6IRqvU6RmBrCzGgcQEW" +
            "8GSyIaQp2E89KRzQhWjBU7G0dSFD+vE+V14nHJF0/uG9LEXw3vSbFcleeOZW2LavliHv9pb1RtKUfTv64hjHetxzZWOlUKE2kXwtfnFY32C" +
            "LsK6Fu8SiVYS3euAK+FJfDDFnX03zR+hO8H9YDs/AxydtT3XI7ONcAW9MX2kfAV3e9x4OCe6eBohksvBCvYIAAmq+HDzqrRf6pkbrqTKqgK" +
            "E5txQ34NT5i8xVeML906dBUe1KXdJNyxNUU0oNvYD697g5RkryepLHGZWY7k71/ZTm+Lye3gfYSL4fp/9p152ETDxN5gJ25eawIDAQAB";

    //"http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";
    //服务器异步通知页面路径 : http://  或者 https:// 格式的完整路径，不能加自定义参数（?id=12）,必须外网能正常访问
    public static String notify_url = "http://zqqe3t.natappfree.cc/notify_url";

    //"http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp"   同步地址是支付成功后跳转的地址
    //页面跳转同步通知页面路径：http://  或者 https:// 格式的完整路径，不能加自定义参数（?id=12）,必须外网能正常访问
    public static String return_url = "http://localhost:8888/return_url";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    //返回格式
    public static String format = "json";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 日志记录路径
    public static String log_path = "E:\\";

}
