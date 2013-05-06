<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link href="estilo.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1 style="text-align: center; padding-top: 5%;"> Sistema para Barzinho</h1>
        <div id="conteudo" >

            <h1 id="h1" >Consulta de Pedidos</h1> 
            <form action="BuscaPedidosServlet" method="post">

                <p id="p">N&uacute;mero da Mesa:
                    <input type="text" name="mesa" maxlength="6" size="6"/> <input type="submit" value="Verificar Mesa"></input></p>

            </form>
        </div>
    </body>
</html>
