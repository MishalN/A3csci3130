/**
 *
 * Mishal Alnajdi
 * B00562408
 * Assignment 4
 */
 
 firebaseRules:
 {
   "rules": {
     ".read": true,
     ".write": true,
     "businessList":{
       "$businessList":{
         "businessNumber":{
           ".validate": "newData.isString() &&  newData.val().matches(/^[0-9]{9}$/)"
         },
         "name":{
           ".validate": "newData.isString() && newData.val().matches(/^[A-Z]{2,48}/i)"
         },
         "primaryBusiness":{
           ".validate": "newData.isString() && newData.val().matches(/^Fisher|Distributor|Processor|Fish Monger/i)"
         },
         "address":{
           ".validate": "newData.isString() && newData.val().length < 50"
         },
         "province":{".validate": "newData.isString() && newData.val().matches(/^AB|BC|MB|NB|NL|NS|NT|NU|ON|PE|QC|SK|YT|[\"\"]/)"
           
         },
       }
     }
     
   }
 }