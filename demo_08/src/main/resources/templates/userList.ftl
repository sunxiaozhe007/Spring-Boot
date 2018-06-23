<html>
<head>
    <title>展示</title>
    <meta charset="utf-8"/>
</head>
<body>

    <table border="3" align="center" width="50%">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
        </tr>

        <#list list as user>
            <tr>
                <td>${user.userid}</td>
                <td>${user.username}</td>
                <td>${user.userage}</td>
            </tr>
        </#list>
    </table>
</body>
</html>