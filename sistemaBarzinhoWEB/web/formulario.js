// verifica se e um CFP valido 
function validarCPF(cpf) {
    cpf = cpf.replace(/[^\d]+/g,'');
     if(cpf == ''){
        alert("Digite um CPF");
        return false;
    }
   
    add = 0;
    for (i=0; i < 9; i ++)
        add += parseInt(cpf.charAt(i)) * (10 - i);
    rev = 11 - (add % 11);
    if (rev == 10 || rev == 11)
        rev = 0;
    if (rev != parseInt(cpf.charAt(9))){
alert("CPF InvÃ¡lido");
        return false;}
     
    
    add = 0;
    for (i = 0; i < 10; i ++)
        add += parseInt(cpf.charAt(i)) * (11 - i);
    rev = 11 - (add % 11);
    if (rev == 10 || rev == 11)
        rev = 0;
    if (rev != parseInt(cpf.charAt(10))){
alert("CPF InvÃ¡lido");
        return false;}
         
alert("CPF vÃ¡lido");
    return true;
    
}

// // 

// verifica se o email possui campos validos


function checarEmail(){
if( document.forms[0].email.value=="" 
   || document.forms[0].email.value.indexOf('@')==-1 
     || document.forms[0].email.value.indexOf('.')==-1 )
	{
		alert( "Por favor, informe um E-MAIL vÃ¡lido!" );
		return false;
	}
}


// // // 


function mascara_data(data){ 
              var mydata = ''; 
              mydata = mydata + data; 
              if (mydata.length == 2){ 
                  mydata = mydata + '/'; 
                  document.forms[0].data.value = mydata; 
              } 
              if (mydata.length == 5){ 
                  mydata = mydata + '/'; 
                  document.forms[0].data.value = mydata; 
              } 
              if (mydata.length == 10){ 
                  verifica_data(); 
              } 
          } 
           
function verifica_data () { 

            dia = (document.forms[0].data.value.substring(0,2)); 
            mes = (document.forms[0].data.value.substring(3,5)); 
            ano = (document.forms[0].data.value.substring(6,10)); 

            situacao = ""; 
            // verifica o dia valido para cada mes 
            if ((dia < 01)||(dia < 01 || dia > 30) && (  mes == 04 || mes == 06 || mes == 09 || mes == 11 ) || dia > 31) { 
                situacao = "falsa"; 
            } 

            // verifica se o mes e valido 
            if (mes < 01 || mes > 12 ) { 
                situacao = "falsa"; 
            } 

            // verifica se e ano bissexto 
            if (mes == 2 && ( dia < 01 || dia > 29 || ( dia > 28 && (parseInt(ano / 4) != ano / 4)))) { 
                situacao = "falsa"; 
            } 
    
            if (document.forms[0].data.value == "") { 
                situacao = "falsa"; 
            } 
    
            if (situacao == "falsa") { 
                alert("Data invÃ¡lida!"); 
                document.forms[0].data.focus(); 
            }

	}			
           

// se tiver alguma letra nÃ£o passa campo 
stop = '';
function telefone( campo ) {
        campo.value = campo.value.replace( /[^\d]/g, '' )
                                 .replace( /^(\d\d)(\d)/, '($1) $2' )
                                 .replace( /(\d{4})(\d)/, '$1-$2' );
        if ( campo.value.length > 14 ) campo.value = stop;
        else stop = campo.value;    
}

// se tiver campo nome em branco alert

function verifica()
   {
        if (formulario.campo1.value=="")
            alert("Por favor, Digite o nome!");

        return false;  
       
   }


function mudarCor(){
}



