export interface Patient {
  id: number;
  name: string;
  insProvider: string;
  email: string;
  phoneNumber: string;
  address: string;
  bloodType: string;
  affliction: string;
  treatment: string;
  inHospital: string;
  age: string;
  sex: string;
  birthdate: string;
  code: string;

  /* constructor(id: number, name: string, insProvider: string, email: string, phoneNumber: string, address: string, bloodType: string, affliction: string, treatment: string, inHospital: string, age: string, sex: string, birthdate: string, code: string) {
		this.id = id;
    this.name = name;
	  this.insProvider = insProvider;
	  this.email = email;
	  this.phoneNumber = phoneNumber;
	  this.address = address;
	  this.bloodType = bloodType;
	  this.affliction = affliction;
	  this.treatment = treatment;
	  this.inHospital = inHospital;
	  this.age = age;
	  this.sex = sex;
	  this.birthdate = birthdate;
    this.code = code;
  }
  */
}
