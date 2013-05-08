// Esta função deixa a primeira letra do campo nome em letra maiúcula
function primeiraLetraMaiuscula() {
    var nome = formulario.campo1.value;
    var nomes = nome.split(" ");
    for (var i = 0; i < nomes.length; i++) {
        nomes[i] = nomes[i].toLowerCase();
        nomes[i] = nomes[i].replace(nomes[i].substr(0, 1), nomes[i].charAt(0).toUpperCase());
        //            alert(nomes[i]);
    }
    nome = "";
    for (var i = 0; i < nomes.length; i++) {
        nome = nome + nomes[i] + " "
    }
    nome = nome.substr(0, nome.length - 1);
    //    alert(nome);
    formulario.campo1.value = nome;
}

// Esta função verifica a existencia de caracteres invalidos
function verificaCarecteresInvalidos() {
    er = /[0-9]/;
    er2 = /[!"#$%&'()*+,\-./:;<=>?@[\\\]^_`{|}~]/;
    var digito = formulario.campo1.value;
    var temp = true;
    for (var i = 0; i < digito.length; i++) {
        if (er.test(digito) || er2.test(digito)) {
            temp = false;
        }
    }
    if (!temp) {
        alert("Nome não pode conter números ou caracteres especias!");

    }
    return temp;
}
// Esta função verifica nome informado
function verificaNome()
{
    var conf = true;


    conf = verificaCarecteresInvalidos();


    return conf;
}
//  Esta função aplica mascara ao campo data
function mascara_data() {
    er = /[0-9]/;
    var digito = formulario.data.value;
    for (var i = 0; i < digito.length; i++) {
        if (i != 2 && i != 5) {
            if (!er.test(digito[i])) {
                document.formulario.data.value = digito.substring(0, digito.length - 1);
            }
        }
    }
    var data = document.formulario.data.value;
    var dataInformada = "";
    dataInformada = dataInformada + data;
    if (dataInformada.length == 2) {
        dataInformada = dataInformada + "/";
        document.formulario.data.value = dataInformada;
    }
    if (dataInformada.length == 5) {
        dataInformada = dataInformada + "/";
        document.formulario.data.value = dataInformada;
    }
}
// Esta função verifica data informada
function verifica_data() {

    var dia = (document.formulario.data.value.substring(0, 2));
    var mes = (document.formulario.data.value.substring(3, 5));
    var ano = (document.formulario.data.value.substring(6, 10));


    //    alert(ano);

    var situacao = true;
    // verifica o dia valido para cada mes 
    if ((dia < 01) || (dia < 01 || dia > 30) && (mes == 04 || mes == 06 || mes == 09 || mes == 11) || dia > 31) {
        situacao = false;
    }

    // verifica se o mes e valido 
    if (mes < 01 || mes > 12) {
        situacao = false;
    }

    // verifica se e ano bissexto 
    if (mes == 2 && (dia < 01 || dia > 29 || (dia > 28 && (parseInt(ano / 4) != ano / 4)))) {
        situacao = false;
    }
    if (ano >= new Date().getFullYear()) {
        situacao = false;
    }

    if (document.formulario.data.value == "") {
        situacao = false;
    }

    if (!situacao) {
        alert("Data inválida!");
    }
    return situacao;
}
//  Esta função aplica mascara ao CPF
function mascara_cpf() {
    er = /[0-9]/;
    var digito = formulario.cpf.value;
    for (var i = 0; i < digito.length; i++) {
        if (i != 3 && i != 7 && i != 11) {
            if (!er.test(digito[i])) {
                document.formulario.cpf.value = digito.substring(0, digito.length - 1);
            }
        }
    }
    var cpf = document.formulario.cpf.value;
    var cpfInformado = "";
    cpfInformado = cpfInformado + cpf;
    if (cpfInformado.length == 3) {
        cpfInformado = cpfInformado + ".";
        document.formulario.cpf.value = cpfInformado;
    }
    if (cpfInformado.length == 7) {
        cpfInformado = cpfInformado + ".";
        document.formulario.cpf.value = cpfInformado;
    }
    if (cpfInformado.length == 11) {
        cpfInformado = cpfInformado + "-";
        document.formulario.cpf.value = cpfInformado;
    }
    if (cpfInformado.length > 13) {
        cpfInformado = cpfInformado.substr(0, cpfInformado.length - 1);
        document.formulario.cpf.value = cpfInformado;
    }
}

// verifica se e um CFP valido 
function validarCPF(cpf) {
    cpf = cpf.replace(/\.|\-/g, "");
//    alert(cpf);
    add = 0;
    for (i = 0; i < 9; i ++)
        add += parseInt(cpf.charAt(i)) * (10 - i);
    rev = 11 - (add % 11);
    if (rev == 10 || rev == 11)
        rev = 0;
    if (rev != parseInt(cpf.charAt(9))) {
        alert("CPF Inválido");
        return false;
    }

    add = 0;
    for (i = 0; i < 10; i ++)
        add += parseInt(cpf.charAt(i)) * (11 - i);
    rev = 11 - (add % 11);
    if (rev == 10 || rev == 11)
        rev = 0;
    if (rev != parseInt(cpf.charAt(10))) {
        alert("CPF Inválido");
        return false;
    }
    return true;
}
//  Esta função verifica e-mail
function checarEmail() {

    if (document.forms[0].email.value == "" || document.forms[0].email.value.indexOf("@") == -1 || document.forms[0].email.value.indexOf(".") == -1) {
        alert("Por favor, informe um E-MAIL válido!");
        return false;
    }
    return true;
}
//  Esta função aplica mascara em telefone
function telefone(campo) {
    stop = "";
    campo.value = campo.value.replace(/[^\d]/g, "").replace(/^(\d\d)(\d)/, "($1) $2").replace(/(\d{4})(\d)/, "$1-$2");
    if (campo.value.length > 14)
        campo.value = stop;
    else
        stop = campo.value;
}

//  Esta função limpa formulário
function confirmaLimparCampo() {
    var conf = confirm("Deseja limpar seu formulário mesmo?");
    if (conf) {
        document.formulario.reset();
        zeraBorda();
    }
}

//  Esta função deixa bordas cinzas
function zeraBorda() {
    document.formulario.campo1.style.border = '1px solid #D3D3D3';
    document.formulario.data.style.border = '1px solid #D3D3D3';
    document.formulario.cpf.style.border = '1px solid #D3D3D3';
    document.formulario.email.style.border = '1px solid #D3D3D3';
    document.formulario.textarea.style.border = '1px solid #D3D3D3';
}

//  Esta função verifica campos vazios
function campoVazios() {
    if (formulario.campo1.value == "") {
        document.formulario.campo1.value = prompt("Por favor, Digite o nome:");
        campoVazios();
    }
    if (document.formulario.data.value == "") {
        document.formulario.data.value = prompt("Por favor, Digite uma data:");
        campoVazios();
    }
    if (document.formulario.cpf.value == "") {
        document.formulario.cpf.value = prompt("Por favor, Digite um cpf:");
        campoVazios();
    }
    if (document.formulario.email.value == "") {
        document.formulario.email.value = prompt("Por favor, Digite um email:");
        campoVazios();

    }

    var textarea = document.getElementById('textarea');
    if (textarea.value.length == 0) {
        document.formulario.textarea.value = prompt("Por favor, Digite um comentário:");
        campoVazios();
    }

}
//  Esta função verifica campos
function validaCampos() {
    campoVazios();
    var x = verificaNome();
    zeraBorda();
    if (!x) {
        document.formulario.campo1.style.border = '2px solid #FF0000';
        document.formulario.campo1.style.color='#FF0000';
    }
    var y = verifica_data();
    if (!y) {
        document.formulario.data.style.border = '2px solid #FF0000';
        document.formulario.data.style.color='#FF0000';
    }
    var z = validarCPF(document.formulario.cpf.value);
    if (!z) {
        document.formulario.cpf.style.border = '2px solid #FF0000';
        document.formulario.cpf.style.color='#FF0000';
    }
    var q = checarEmail();
    if (!q) {
        document.formulario.email.style.border = '2px solid #FF0000';
        document.formulario.email.style.color='#FF0000';
    }
    var u = verificaComentario();
    if (!u) {
        document.formulario.textarea.style.border = '2px solid #FF0000';
        document.formulario.textarea.style.color='#FF0000';
    }
    if (x && y && z && q && u) {
        document.formulario.submit();
    }
}
//  Esta função varia estilos
function setActiveStyleSheet() {
    var i, nomeLinkCss, estiloSelecionadoCss;
    estiloSelecionadoCss = document.getElementById("escolheEstilo").value;
    for (i = 0; (nomeLinkCss = document.getElementsByTagName("link")[i]); i++) {
        if (nomeLinkCss.getAttribute("rel").indexOf("style") != -1 && nomeLinkCss.getAttribute("title")) {
            nomeLinkCss.disabled = true;
            if (nomeLinkCss.getAttribute("title") == estiloSelecionadoCss) {
                nomeLinkCss.disabled = false;
                GerarCookie("estilo", estiloSelecionadoCss);
            }
        }
    }
}

function mudaEstilo(estilo) {
    var i, nomeLinkCss, estiloSelecionadoCss;
    estiloSelecionadoCss = estilo;
//    alert(estiloSelecionadoCss)
    for (i = 0; (nomeLinkCss = document.getElementsByTagName("link")[i]); i++) {
        if (nomeLinkCss.getAttribute("rel").indexOf("style") != -1 && nomeLinkCss.getAttribute("title")) {
            nomeLinkCss.disabled = true;
            if (nomeLinkCss.getAttribute("title") == estiloSelecionadoCss) {
                nomeLinkCss.disabled = false;
                GerarCookie("estilo", estiloSelecionadoCss);
            }
        }
    }
}

function GerarCookie(strCookie, strValor) {
//    alert(strCookie + "=" + strValor + strExpires + "; path=/");
    var o_cookie = strCookie + "=" + strValor + ";";
    document.cookie = o_cookie;
//    alert(LerCookie("estilo"));

}

function LerCookie(strCookie)
{
    var strNomeIgual = strCookie + "=";
    var arrCookies = document.cookie.split(';');
    for (var i = 0; i < arrCookies.length; i++) {
        var strValorCookie = arrCookies[i];
        while (strValorCookie.charAt(0) === ' ')
        {
            strValorCookie = strValorCookie.substring(1, strValorCookie.length);
        }
        if (strValorCookie.indexOf(strNomeIgual) == 0)
        {
//            alert("aaaaaa");
            return strValorCookie.substring(strNomeIgual.length, strValorCookie.length);
        }
    }
    return null;
}

function setSelectedComCookie() {
//    alert("aa")
    if (LerCookie("estilo") != null) {
//        alert("bb")
        var estilo = LerCookie("estilo").substring(LerCookie("estilo").lastIndexOf("o") + 2, LerCookie("estilo").length);
//        alert(estilo);
        var op = document.getElementById("escolheEstilo");
        op.options[estilo - 1].selected = true;
//        alert(op.options[estilo - 1].value);
        mudaEstilo(LerCookie("estilo"));
//        alert(LerCookie("estilo"));
    }
}


//função  para Mapa do Site Dinâmico
function mapaSiteDinamico() {
    var div = document.getElementById("navegacao");
    var localizacao = window.location.toString();
//    alert(localizacao);
    var paginas = new Array();
    paginas[0] = "home.html";
    paginas[1] = "descricaoSistema.html";
    paginas[2] = "desenvolvedores.html";
    paginas[3] = "Screenshots.html";
    paginas[4] = "Mapadosite.html";
    paginas[5] = "Formulario.html";

    var i;
    for (i = 0; i < paginas.length; i++) {
        if (localizacao.contains("home")) {
            div.innerHTML = window.parent.document.title;
        } else {
//            alert("bbv")
            if (localizacao.contains(paginas[1])) {
                div.innerHTML = "<a href='home.html'>Home </a>" + ">> " + window.parent.document.title;
            } else if (localizacao.contains(paginas[2])) {
                div.innerHTML = "<a href='home.html'>Home </a>" + ">> " + window.parent.document.title;
            } else if (localizacao.contains(paginas[3])) {
                div.innerHTML = "<a href='home.html'>Home </a>" + ">> " + window.parent.document.title;
            } else if (localizacao.contains(paginas[4])) {
                div.innerHTML = "<a href='home.html'>Home </a>" + ">> " + window.parent.document.title;
            } else if (localizacao.contains(paginas[5])) {
                div.innerHTML = "<a href='home.html'>Home </a>" + ">> " + window.parent.document.title;
            }
        }
    }
}
