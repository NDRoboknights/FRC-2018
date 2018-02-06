#include <boarddefs.h>
#include <IRremote.h>
#include <IRremoteInt.h>
#include <ir_Lego_PF_BitStreamEncoder.h>

const String IRConnect = "C";
const String IRDisconnect = "D";

void setup() 
{
  Serial.begin(8600);
  enableIRIn();
  enableIROut(3);
}

void loop() 
{
  irsend.sendSony(0xa90, 12);
  
  if(irrecv.decode(&results) && results.value == 0xa90)
  {
    Serial.write(IRConnect);
  }
  else 
  {
    Serial.write(IRDisconnect);
  }

  Serial.flush();
  delay(20);
}
