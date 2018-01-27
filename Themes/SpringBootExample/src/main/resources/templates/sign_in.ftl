<#ftl encoding='UTF-8'>
<#include "header.ftl">
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<body>
<#if model.error??>
    <h1>Ошибка</h1>
</#if>
<form method="post" action="/signIn">
    <input type="text" name="email" placeholder="E-mail">
    <input type="password" name="password" placeholder="Пароль">
    <input type="checkbox" name="remember-me" placeholder="Запомнить">
    <input type="submit">
</form>
</body>
</html>