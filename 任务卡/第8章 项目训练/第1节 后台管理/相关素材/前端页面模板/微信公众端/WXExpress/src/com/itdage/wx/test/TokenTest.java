package com.itdage.wx.test;

import org.junit.Test;

import com.itdage.wx.util.SignatureUtil;
import com.itdage.wx.util.TicketUtil;
import com.itdage.wx.util.TokenUtil;

public class TokenTest {

	@Test
	public void test1() throws Exception {
		String token1 = TokenUtil.getToken();
		System.out.println(token1);
		token1 = TokenUtil.getToken();
		System.out.println(token1);
		token1 = TokenUtil.getToken();
		System.out.println(token1);
		token1 = TokenUtil.getToken();
		System.out.println(token1);
	}
	@Test
	public void test2() throws Exception {
		String ticket = TicketUtil.getTicket();
		System.out.println(ticket);
		ticket = TicketUtil.getTicket();
		System.out.println(ticket);
		ticket = TicketUtil.getTicket();
		System.out.println(ticket);
	}
	@Test
	public void test3() throws Exception {
		String s = SignatureUtil.getConfig("http://itdage.cn/ee/x.html").toJSON();
		System.out.println(s);
	}
}
