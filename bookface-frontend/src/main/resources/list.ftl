<#-- @ftlvariable name="" type="com.kainos.training.dropwizard.login.frontends.views.BookView" -->

<h1>People list</h1>
<p class="lead">books ${bookCount}</p>

<table class="table">
    <thead>
        <th>Title</th>
        <th>Author</th>
    </thead>

    <tbody>
        <#list books as book>
            <tr>
            <td>
                ${book.title}
            </td>
            <td>
                ${book.author}
            </td>
            </tr>
        </#list>

    </tbody>
</table>