<html>
<body>
<table>
    <#list result as row>
        <tr>
            <#list row as cell>
                <#if row?is_first>
                    <th>${cell}</th>
                <#else>
                    <td>${cell}</td>
                </#if>
            </#list>
        </tr>
    </#list>
</table>
</body>
</html>