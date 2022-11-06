<#import "main.ftlh" as main>
<@main.main>
    <div class="row">
        <#list games as game>
            <div class="col s4">
                <div class="card blue-grey darken-1">
                    <div class="card-content white-text">
                        <span class="card-title">${game.title}</span>
                        <p>${game.description}</p>
                    </div>
                    <div class="card-action">
                        <a href="#">This is a link</a>
                        <a href="#">This is a link</a>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</@main.main>