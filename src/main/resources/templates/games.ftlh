<#import "main.ftlh" as main>
<@main.main>
    <title>Главная</title>
    <div class="row">
        <#list games as game>
            <div class="col s4">
                <div class="card">
                    <div class="card-image">
                        <img src="${game.imgPath}">
                        <span class="card-title">${game.title}</span>
                    </div>
                    <div class="card-content">
                        <p>${game.description}</p>
                    </div>
                    <div class="card-action">
                        <a href="/game/${game.id}">This is a link</a>
                    </div>
                </div>
            </div>
        </#list>
        <#list games as game>
            <div class="row">

            </div>

            </div>
        </#list>

    </div>
</@main.main>