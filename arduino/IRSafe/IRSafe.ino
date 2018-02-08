#include <IRremote.h>
#include <IRremoteInt.h>

const String Ready = "rdy";
const String IRConnect = "Con";
const String IRDisconnect = "Dis";

int RECV_PIN = 11;
IRrecv irrecv(RECV_PIN);
decode_results results;
IRsend irsend;

void setup() 
{
  Serial.begin(9600);
  irrecv.enableIRIn();
  irsend.enableIROut(38);
}

void loop() 
{
  while(Serial.available() < 3)
  {
    delay(5);
  }

  char chars[3];
  Serial.readBytes(chars, 3);
  String str = "";
  for(int i=0; i<3; i++)
  {
    str += chars[i];
  }

  if(str.equals(Ready))
  {
    irsend.sendSony(0xa90, 12);
    
    if(irrecv.decode(&results) && results.value == 0xa90)
    {
      writeString(IRConnect);
    }
    else 
    {
      writeString(IRDisconnect);
    }
  }
  
  Serial.flush();
}

void writeString(String stringData) { // Used to serially push out a String with Serial.write()

  for (int i = 0; i < stringData.length(); i++)
  {
    Serial.write(stringData[i]);   // Push each char 1 by 1 on each loop pass
  }

}// end writeString
