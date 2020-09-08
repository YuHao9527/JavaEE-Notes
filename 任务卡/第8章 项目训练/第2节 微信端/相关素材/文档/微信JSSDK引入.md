

### 前置需求

```
 mp.weixin.qq.com 申请自己的微信公众号
```



### 1. 务必修改

	
	 	1.	com.kaikeba.wx.util.SignatureUtil类 88 行的appid  否则无法调用api
	 	2.	com.kaikeba.wx.util.TokenUtil类的34行的appid
	 	3.	com.kaikeba.wx.util.TokenUtil类的35行的secret
	
	appid和密钥来自于: 
		mp.weixin.qq.com --> 开发者设置
		


   

### 2. 添加JS安全域名:

```
自己再ngrok官网定义的:xxx.zaixianke.cn
```


​	

### 3. 添加白名单ip:

	1.	映射服务器地址:64.69.43.237   
	2.	本机ip地址: 百度或360搜索 ip:111.203.4.66

