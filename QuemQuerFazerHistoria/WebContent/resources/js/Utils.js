//-------------------
// Redimensiona o iFrame com a altura da página
//-------------------
function redimensionarFrame()
{
	try{	
		
		var oBody	=	iframeCentro.document.body;
		var oFrame	=	document.all("iframeCentro");
		var altura	= 	oBody.scrollHeight + (oBody.offsetHeight - oBody.clientHeight);
		
		oFrame.style.height = altura +'px';
		
	}
	catch(e)
	{
		alert('Error: ' + e.number + '; ' + e.description);
	}
}

//-------------------
// Captura o teclado do usuário e verifica se o Enter foi pressionado
//-------------------
function onEnter(evt)
{
    var key_code = evt.keyCode  ? evt.keyCode  :
                   evt.charCode ? evt.charCode :
                   evt.which    ? evt.which    : void 0;
 
    if (key_code == 13)
    {
        return true;
    }
}

//-------------------
// Cria o método replaceAll na classe String
//-------------------
String.prototype.replaceAll = function(de, para){
    var str = this;
    var pos = str.indexOf(de);
    while (pos > -1){
		str = str.replace(de, para);
		pos = str.indexOf(de);
	}
    return (str);
};

//-------------------
// Volta uma página de acordo com o historico do navegador
//-------------------
function voltar()
{
	history.back(-1);
}