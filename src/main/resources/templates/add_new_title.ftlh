<#import "main.ftlh" as main>
<@main.main>
    <title>Hello to add!</title>
    <body>
    <form action="">
        <div class="input-field col s12">
            <select>
                <option value="" disabled selected>Choose your option</option>
                 <#list genres as genre>
                     <option value="${genre.id}">${genre.name}</option>
                 </#list>
            </select>
            <label>Materialize Select</label>
        </div>
    </form>
    </body>
</@main.main>