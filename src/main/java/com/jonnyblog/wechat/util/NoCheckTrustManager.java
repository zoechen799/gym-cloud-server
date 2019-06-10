package com.jonnyblog.wechat.util;


import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * ClassName: NoCheckTrustManager
 * Description:
 * date: 2019/6/10 12:46 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
public class NoCheckTrustManager implements X509TrustManager {

  @Override
  public void checkClientTrusted(X509Certificate[] chain, String authType)
      throws CertificateException {
  }

  @Override
  public void checkServerTrusted(X509Certificate[] chain, String authType)
      throws CertificateException {
  }

  @Override
  public X509Certificate[] getAcceptedIssuers() {
    return null;
  }

}