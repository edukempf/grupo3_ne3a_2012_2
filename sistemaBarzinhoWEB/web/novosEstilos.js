function setActiveStyleSheet(estilo) {
                var i, a;
                for(i=0; (a = document.getElementsByTagName("link")[i]); i++)
                { if(a.getAttribute("rel").indexOf("style") != -1 && a.getAttribute("title"))
                    { a.disabled = true;
                        if(a.getAttribute("title") == estilo) a.disabled = false;
                    }
                }
            }

function setCookie(c_name,value,exdays)  // criar cookie
{
	var exdate=new Date();
	exdate.setDate(exdate.getDate() + exdays);
	var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
	document.cookie=c_name + "=" + c_value;
}

function getCookie(c_name){ // retorna o cookie
	var i,x,y,ARRcookies=document.cookie.split(";");
	for (i=0;i<ARRcookies.length;i++)
	{
  		x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
  		y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
  		x=x.replace(/^\s+|\s+$/g,"");
  		if (x==c_name)
    			{
    			return unescape(y);
    			}
  	}

}