 class run {
  var x=0;
  var alphabetc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  var alphabets = "abcdefghijklmnopqrstuvwxyz";
  
  def cipher(func:()=>String):String = func();

  def encrypt():String = {
        val shift = (scala.io.StdIn.readLine("Shift By: ").toInt + alphabets.size) % alphabets.size;
        val inputText = scala.io.StdIn.readLine("\nSecret Message: ");
        val outputText = inputText.map( (c: Char) => {
            
            if(c.isUpper){
                x = alphabetc.indexOf(c);
            }
            else{
                x = alphabets.indexOf(c);
            }

            if(x == -1){
                c;
            }
            else{
                if(c.isUpper)
                {
                    alphabetc((x + shift) % alphabets.size);
                }
                else{
                    alphabets((x + shift) % alphabets.size);
                }
            }
        }
        );
        return outputText;
  }

  def decrypt():String = {
        val shift = (scala.io.StdIn.readLine("Shift By: ").toInt + alphabets.size) % alphabets.size;
        val inputText = scala.io.StdIn.readLine("\nSecret Message: ");
        val outputText = inputText.map( (c: Char) => {
            
            if(c.isUpper){
                x = alphabetc.indexOf(c);
            }
            else{
                x = alphabets.indexOf(c);
            }

            if(x == -1){
                c;
            }
            else{
                if(c.isUpper)
                {
                    alphabetc((alphabets.size + x - shift) % alphabets.size);
                }
                else{
                    alphabets((alphabets.size + x - shift) % alphabets.size);
                }
            }
        }
        );
        return outputText;
  }
  
}
 
 
  

object encrptrun {
  

  def main(args: Array[String]): Unit =
  {
    val eORd = scala.io.StdIn.readLine("1. Encryption\n2. decrption \n").toInt;
    
    val test = new run();

    if(eORd == 1)
    {
        println(test.cipher(test.encrypt));
    }
    else if(eORd == 2)
    {
        println(test.cipher(test.decrypt));
    }


    
  }
  
  
}