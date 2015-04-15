function getQueryString(variavel){
   var variaveis=location.search.replace(/\x3F/,"").replace(/\x2B/g," ").split("&");
   var nvar;
   if(variaveis!=""){
      var qs=[ ];
      for(var i=0;i<variaveis.length;i++){
         nvar=variaveis[i].split("=");
         qs[nvar[0]]=unescape(nvar[1]);
      }
      return qs[variavel];
   }
   return null;
}

function getSelecionado(radios)
{
	var selecionado="";

	for(var i=0;i<radios.length;i++) {
		if(radios[i].checked) {
			selecionado = radios[i].id;
			break;
		}
	}
	
	return selecionado;
}

function onVoltar(destino, obj)
{
	switch (destino) {
	case 'home':
		obj.href = "aHome#destino";
		break;
	case 'nivel1':
		var p = getQueryString("p");
		obj.href = "pnivel1?p=" + p + "#destino";
		break;
	case 'nivel2':
		var p = getQueryString("p");
		var n1 = getQueryString("n1");
		obj.href = "pnivel2?p="+p+"&n1="+n1+"#destino";
		break;
	case 'nivel3':
		var p = getQueryString("p");
		var n1 = getQueryString("n1");
		var n2 = getQueryString("n2");
		obj.href = "pnivel3?p="+p+"&n1="+n1+"&n2="+n2+"#destino";
		break;
	default:
		obj.href = "aHome#destino";
		break;
	}
}

function exibeloading() {
	if (document.getElementById("loading").style.display == "none") {
		document.getElementById("loading").style.display 	= "inline";
		document.getElementById("form").style.display 		= "none";
		document.getElementById("btnVoltar").style.display 	= "none";
		document.getElementById("espaco").style.display 	= "inline";
	} else {
		document.getElementById("loading").style.display 	= "none";
		document.getElementById("form").style.display 		= "inline";
		document.getElementById("btnVoltar").style.display 	= "inline";
		document.getElementById("espaco").style.display 	= "none";
		
	}
}

function isImagemValida(imagem)
{
	var arr = ['jpg','gif','png','jpeg','bmp'];
	var extensao = imagem.substring(imagem.lastIndexOf('.')+1, imagem.length);
	for(var i=0; i<arr.length; i++)
	{
		if(arr[i] == extensao)
			return true;
	}
	return false;
}