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
  sendRaw(new unsigned int[]{1,2,3,5}, 4, 3000);
  if(irrecv.decode(&results)
  {
    Serial.write(IRConnect);
  }
  else 
  {
    Serial.write(IRDisconnect);
  }
}
