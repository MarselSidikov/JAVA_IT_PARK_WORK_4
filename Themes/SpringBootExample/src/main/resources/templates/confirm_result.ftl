<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<#if model.confirmResult == true>
    <h1>Успешно</h1>
<#else>
    <h1>Не успешно</h1>
</#if>
</html>