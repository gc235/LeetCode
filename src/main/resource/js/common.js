function runEncrypt(str) {
  var publickey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA73jDjqpLU/z2J2yhTTgH9wgN/Ztym1wRqhHcpAevdEHmJ02/+Qm+2rEHlAfUZR89WD6rxOjMRukIjojmxCIzdZMvN9HM1oZO+PHfpWV1vcxKiCKqfhZgtHSY8IkXGybg45mfhl8Ds3Huji2RPNkBMj8KPU2Ofb8HtBptl/hIGy1rctWy4GSceb7arra5Il+wsjV46Yig/bwrldkePwSZvbRja/DOZCtLOMQJv41rvRH1gSYoWwd5KeJQT1lWBBIoFbfNGSlr8H7ejt1nWJInlRVceWy157eeLqPz9TmEqrYD5VAFqn1sYMphysXIHUPr3IUZJWnooT/330k6A2ec8QIDAQAB";
  var encrypt = new JSEncrypt();
  encrypt.setPublicKey(publickey);
  var encrypted = encrypt.encrypt(str);
  return encrypted
}