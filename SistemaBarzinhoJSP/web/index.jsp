<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link href="estilo.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1 style="text-align: center;padding-top: 5%;"> Sistema para Barzinho</h1>
        <div id="conteudo" >

            <h1 id="h1" >Consulta de Pedidos</h1>
            <form action="butoon" method="post">

                <p id="p">C&oacute;digo do Pedido:
                    <input type="text" name="pedido" maxlength="6" size="6"/> <input type="button" value="Verificar Pedido"></input></p>
                <p id="p">N&uacute;mero da Mesa:
                    <input type="text" name="mesa" maxlength="6" size="6"/> <input type="button" value="Verificar Mesa"></input></p>
                <p id="p">Nome do Funcion&aacute;rio:
                    <input type="text" name="funcionario" maxlength="6" size="40"/> </p>
                <p id="p">Pratos Relacionados a este pedido:
                  <textarea id="textarea" name="pratos" rows="5" cols="50"></textarea> </p>
                <p>Data de Pedido:
                    <select>
                        <option>Dia</option> <option>01</option>
                        <option>02</option>  <option>03</option>
                        <option>04</option>  <option>05</option>
                        <option>06</option>  <option>07</option>
                        <option>08</option>  <option>09</option>
                        <option>10</option>  <option>11</option>
                        <option>12</option>  <option>13</option>
                        <option>14</option>  <option>15</option>
                        <option>16</option>  <option>17</option>
                        <option>18</option>  <option>19</option>
                        <option>20</option>  <option>21</option>
                        <option>22</option>  <option>23</option>
                        <option>24</option>  <option>25</option>
                        <option>26</option>  <option>27</option>
                        <option>28</option>  <option>29</option>
                        <option>30</option>  <option>31</option>

                    </select> 
                    <select> 
                        <option>M&ecirc;s</option>
                        <option>Janeiro</option>  <option>Fevereiro</option>
                        <option>Março</option>    <option>Abril</option>
                        <option>Maio</option>     <option>Junho</option>
                        <option>Julho</option>    <option>Agosto</option>
                        <option>Setembro</option> <option>Outubro</option>
                        <option>Novembro</option> <option>Dezembro</option>

                    </select>
                    <select> 
                        <option>Ano</option>
                        <option>2010</option>  <option>2011</option>
                        <option>2012</option>  <option>2013</option>
                        <option>2014</option>  <option>2015</option>
                        <option>2016</option>  <option>2017</option>
                        <option>2018</option>  <option>2019</option>
                        <option>2020</option>  <option>2021</option>
                        <option>2022</option>  <option>2023</option>

                    </select></p>

                <input type="button" id="submit"value="Verificar Exist&ecirc;ncia do Pedido"></input>

            </form>
        </div>
    </body>
</html>
