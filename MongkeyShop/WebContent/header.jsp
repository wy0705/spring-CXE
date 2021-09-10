<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.html"></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl">
            	<c:if test="${isLogin !=1 }">
            		<a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>
            	
            	</c:if>
            	
            	<c:if test="${isLogin ==1 }">
            		<b>你好：</b><a href="login.jsp" id="login">${name.USER_NAME }</a>
            	
            	</c:if>
            	
            	<c:if test="${isAdminLogin ==1 }">
            		<a href="manage/admin_index.jsp" id="login1">进入后台</a>
            	
            	</c:if>
            </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：干花花瓶"/><input
                        type="button"/></form>
                <div class="btn fl clearfix"><a href="mygxin.jsp"><img src="img/grzx.png"/></a><a href="#" class="er1"><img
                        src="img/ewm.png"/></a>
                      <c:if test="${isLogin ==1 }">  
                        <a href="cart.html"><img src="img/gwc.png"/></a>
                       </c:if> 
                        
                    <p><a href="#"><img src="photo/李.jpg"/></a></p></div>
            </div>
            <ul class="clearfix" id="bott">
                <%--<li><a href="indexselect">首页</a></li>--%>
                    <li><a href="index3.html">首页</a></li>
                    <li><a href="#">所有招聘行业</a>
                        <div class="sList">
                            <div class="wrapper  clearfix"><a href="paint.html">
                                <dl>
                                    <dt><img src="img/nav1.jpg"/></dt>
                                    <dd>IT行业</dd>
                                </dl>
                            </a><a href="paint.html">
                                <dl>
                                    <dt><img src="img/nav2.jpg"/></dt>
                                    <dd>服务行业</dd>
                                </dl>
                            </a><a href="paint.html">
                                <dl>
                                    <dt><img src="img/nav3.jpg"/></dt>
                                    <dd>教育行业</dd>
                                </dl>
                            </a><a href="paint.html">
                                <dl>
                                    <dt><img src="img/nav6.jpg"/></dt>
                                    <dd>高级管理行业</dd>
                                </dl>
                            </a><a href="paint.html">
                                <dl>
                                    <dt><img src="img/nav7.jpg"/></dt>
                                    <dd>主播行业</dd>
                                </dl>
                            </a></div>
                        </div>
                    </li>
                    <li><a href="#">IT行业</a>
                        <div class="sList2">
                            <div class="clearfix"><a href="#">传统行业</a><a href="index.jsp">互联网行业</a></div>
                        </div>
                    </li>
                    <li><a href="decoration.html">服务行业</a>
                        <div class="sList2">
                            <div class="clearfix"><a href="zbprolist.jsp">旅游业</a><a href="bzproList.html">餐饮业</a></div>
                        </div>
                    </li>
                    <li><a href="paint.html">教育行业</a></li>
                    <li><a href="perfume.html">高级管理行业</a></li>
                    <li><a href="idea.html">主播行业</a></li>
                </ul>
        </div>


            <c:forEach var="f" items="${flist }">
            
            <li><a href="selectproductlist?fid=${f.CATE_ID }">${f.CATE_NAME }</a>
                <div class="sList2">
                    <div class="clearfix">
                    	<c:forEach var="c" items="${clist }">
                    		<c:if test="${f.CATE_ID == c.CATE_PARENT_ID }">
                    			<a href="selectproductlist?cid=${c.CATE_ID }">${c.CATE_NAME }</a>
                    		</c:if>
                    	</c:forEach>
                    </div>
                </div>
            </li>
           </c:forEach>
        </ul>
    </div>
</div>