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

function verificaNome()
{
    var conf = true;
    if (formulario.campo1.value == "") {
        alert("Por favor, Digite o nome!");
        conf = false;
    }
    else {
        conf = verificaCarecteresInvalidos();
    }

    return conf;
}

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

function verifica_data() {
    if (document.formulario.data.value == "") {
        alert("Informe uma data!");
        return false;
    }

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
    if (cpf == " ") {
        alert("Digite um CPF");
        return false;
    }

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

function checarEmail() {
    if (document.forms[0].email.value == "" || document.forms[0].email.value.indexOf("@") == -1 || document.forms[0].email.value.indexOf(".") == -1) {
        alert("Por favor, informe um E-MAIL válido!");
        return false;
    }
    return true;
}

function telefone(campo) {
    stop = "";
    campo.value = campo.value.replace(/[^\d]/g, "").replace(/^(\d\d)(\d)/, "($1) $2").replace(/(\d{4})(\d)/, "$1-$2");
    if (campo.value.length > 14)
        campo.value = stop;
    else
        stop = campo.value;
}


function confirmaLimparCampo() {
    var conf = confirm("Deseja limpar seu formulário mesmo?");
    if (conf) {
        document.formulario.reset()
    }
}

function verificaComentario() {
    var teste = true;
    var textarea = document.getElementById('textarea');
    if (textarea.value.length == 0) {
         alert("Por favor, informe um comentário válido!");
        teste = false;
    }
    return teste;

}

function validaCampos() {
    var x = verificaNome();
    if (!x) {
        document.formulario.campo1.style.border = '2px solid red';
    }
    var y = verifica_data();
    if (!y) {
        document.formulario.data.style.border = '2px solid red';
    }
    var z = validarCPF(document.formulario.cpf.value);
    if (!z) {
        document.formulario.cpf.style.border = '2px solid red';
    }
    var q = checarEmail();
    if (!q) {
        document.formulario.email.style.border = '2px solid red';
    }
    var u = verificaComentario();
    if (!u) {
        document.formulario.textarea.style.border = '2px solid red';
    }
    if (x && y && z && q && u) {
        document.formulario.submit();
    }
}

