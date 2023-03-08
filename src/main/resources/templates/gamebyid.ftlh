<#import "main.ftlh" as main>
<@main.main>
<title>${gamebyid.title}</title>
    <body>
    <h1 style="text-align: center">${gamebyid.title}</h1>
    <ul>
        <li >
            ${gamebyid.genre}
        </li>
        <li>
            ${gamebyid.releaseDate}
        </li>
        <li>
            ${gamebyid.description}
        </li>
    </ul>
    <img class="responsive-img" src="${gamebyid.imgPath}" alt="">
    
    </body>
</@main.main>