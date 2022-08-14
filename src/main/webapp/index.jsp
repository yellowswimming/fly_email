<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="lib/styleOuter1.css">
</head>
<body>
<!-- <img src="/image/免抠图/水波.jpg" alt=""> -->
<div class="header">
    <img src="image/免抠图/鸽子大.png" alt="">
</div>
<div class="box">
    <form action="${pageContext.request.contextPath }/login.do" method="post">
        <h2>飞乘邮件</h2>
        <div class="info">${error}</div>
        <div class="input-box">
            <label>账号</label>
            <input type="text" placeholder="用户名" required name="username">
        </div>

        <div class="input-box">
            <label>密码</label>
            <input type="password" placeholder="密码" required name="password">
        </div>

        <div class="btn-box">
            <a href="#">忘记密码?</a>
            <div>
                <button type="submit">登录</button>
                <button type="submit">注册</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
