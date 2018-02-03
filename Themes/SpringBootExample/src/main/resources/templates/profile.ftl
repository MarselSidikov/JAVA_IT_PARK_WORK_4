<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<!doctype html>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="/js/main.js"></script>
    <meta charset="UTF-8">
    <title>Профиль</title>
</head>
<body>
<h1>Ваш профиль</h1>
<div>
    <h2>${model.user.email}</h2>
    <input type="file" name="file" id="fileInput" placeholder="Файл аватара"/>
    <button onclick="imageUpload(document.getElementById('fileInput')['files'][0])">Загрузить</button>
    <br>
    <input type="text" id="name" <#if model.user.name??>
        value="${model.user.name}"
    <#else>
           placeholder="Не заполнено"
    </#if>>
    <input type="text" id="lastName" <#if model.user.lastName??>
        value="${model.user.lastName}"
    <#else>
           placeholder="Не заполнено"
    </#if>>
    <input type="text" id="birthDate" <#if model.user.birthDate??>
        value="${model.user.birthDate}"
    <#else>
           placeholder="Не заполнено"
    </#if>>
    <button onclick="updateUser(
        document.getElementById('name').value,
        document.getElementById('lastName').value,
        document.getElementById('birthDate').value
    )">Сохранить
    </button>
    <div id="avatar">

    </div>
</div>

<a href="/logout">Выход</a>
</body>
</html>
