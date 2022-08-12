<%@ page import="com.hy.util.Constant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>飞乘</title>
    <link rel="stylesheet" href="../lib/style.css">
    <link rel="stylesheet" href="../lib/fontclass/iconfont.css">
</head>
<body>

    <ul>
        <li>
            <div>首页</div>
            <div>首页</div>
        </li>
        <li>
            <div>关于我们</div>
            <div>关于我们</div>
        </li>
        <li>
            <div>服务</div>
            <div>服务</div>
        </li>
        <li>
            <div>案例</div>
            <div>案例</div>
        </li>
        <li>
            <div>用户反馈</div>
            <div>用户反馈</div>
        </li>
    </ul>

    <div class="shell" >
        <a href="#" class="box"> <i class="iconfont icon-xiexin"></i><span>写信</span></a>
        <a href="#" class="box"> <i class="iconfont icon-yifasong"></i><span>已发送</span></a>
        <a href="#" class="box"><i class="iconfont icon-caogaoxiang"></i><span>草稿</span></a>
        <a href="#" class="box"> <i class="iconfont icon-shoujianxiang"></i><span>收件箱</span></a>
        <a href="#" class="box">  <i class="iconfont icon-shequ"></i><span>社区</span></a>
        <a href="${pageContext.request.contextPath }/servlet/logout" class="box">  <i class="iconfont icon-ziyuanxhdpi"></i><span>注销</span></a>
    </div>


</body>
</html>