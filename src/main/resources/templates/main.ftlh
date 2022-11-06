<#macro main>
<!DOCTYPE html>
<html lang="ru">
<head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="/css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>

<body>
<nav>
    <div class="nav-wrapper">
        <a href="#" class="brand-logo">GameCritic</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="sass.html"></a></li>
            <li><a href="badges.html"></a></li>
            <li><a href="collapsible.html">Категории</a></li>
        </ul>
    </div>
</nav>
<#nested>


</body>


<!--JavaScript at end of body for optimized loading-->
<script type="text/javascript" src="/js/materialize.min.js"></script>
</body>
</html>
</#macro>