<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<h1>Ваш профиль</h1>
<h2>${model.user.email}</h2>
<a href="/logout">Выход</a>