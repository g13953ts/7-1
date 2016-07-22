<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/design.css">
        <title>ログイン</title>
    </head>
    <body>
        <div id="header"></div>
        <div id="main">
            <form action="../loginServlet" method="post">
                <input type="text" name="userId" placeholder="ユーザーID"><br />
                <input type="password" name="pass" placeholder="パスワード"><br />
                <input type="submit" value="ログイン">
            </form>
        </div>
        <div id="footer"></div>
    </body>
</html>