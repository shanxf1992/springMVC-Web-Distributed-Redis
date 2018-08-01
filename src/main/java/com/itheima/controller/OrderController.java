package com.itheima.controller;


import com.itheima.utils.PaymentUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@RequestMapping("orderitems")
public class OrderController {

    @RequestMapping("callback")
    public ModelAndView callBack() {
        ModelAndView modelAndView = new ModelAndView();

        return modelAndView;
    }

    @RequestMapping("pay")
    public String payOrder(HttpServletRequest request, HttpServletResponse response) {

        // 获取订单信息
        String orderid = request.getParameter("orderid");
        String money = request.getParameter("money");
        String spd_FrpId = request.getParameter("pd_FrpId");

        // 准备向第三方支付公司提供的数据
        String p0_Cmd = "Buy";
        String p1_MerId = "10001126856";
        String p2_Order = UUID.randomUUID().toString().replace("-", "");
        String p3_Amt = money;
        String p4_Cur = "CNY";
        String p5_Pid = "";
        String p6_Pcat = "";
        String p7_Pdesc = "";
        String p8_Url = "http://localhost:8080/web/orderitems/callback";
        String p9_SAF = "";
        String pa_MP = "";
        String pd_FrpId = spd_FrpId;
        String pr_NeedResponse = "1";
        String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid,
                p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);

        StringBuilder stringBuilder = new StringBuilder("https://www.yeepay.com/app-merchant-proxy/node?");
        stringBuilder.append("p0_Cmd=").append(p0_Cmd).append("&");
        stringBuilder.append("p1_MerId=").append(p1_MerId).append("&");
        stringBuilder.append("p2_Order=").append(p2_Order).append("&");
        stringBuilder.append("p3_Amt=").append(p3_Amt).append("&");
        stringBuilder.append("p4_Cur=").append(p4_Cur).append("&");
        stringBuilder.append("p5_Pid=").append(p5_Pid).append("&");
        stringBuilder.append("p6_Pcat=").append(p6_Pcat).append("&");
        stringBuilder.append("p7_Pdesc=").append(p7_Pdesc).append("&");
        stringBuilder.append("p8_Url=").append(p8_Url).append("&");
        stringBuilder.append("p9_SAF=").append(p9_SAF).append("&");
        stringBuilder.append("pa_MP=").append(pa_MP).append("&");
        stringBuilder.append("pd_FrpId=").append(pd_FrpId).append("&");
        stringBuilder.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
        stringBuilder.append("hmac=").append(hmac);

        System.out.println(stringBuilder.toString());
        return "redirect:" + stringBuilder.toString();
    }


}
