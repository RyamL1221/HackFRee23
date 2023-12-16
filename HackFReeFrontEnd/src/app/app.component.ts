import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core'
import { PatientService } from './patient.service';
import { NgForm } from '@angular/forms';
import { Patient } from './patient';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public patients: Patient[];
  public deletePatient: Patient;
  public editPatient: Patient;

  public title: string = 'HackathonProjectApp';

  constructor(private patientService: PatientService) {}

  ngOnInit() {
    this.getPatients();
  }

  public getPatients(): void {
    this.patientService.getPatients().subscribe(
      (response: Patient[]) => {
        this.patients = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddPatient(addForm: NgForm): void {
    document.getElementById('add-patient-form').click();
    this.patientService.addPatient(addForm.value).subscribe(
      (response: Patient) => {
        console.log(response);
        this.getPatients();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdatePatient(patient: Patient): void {
    this.patientService.updatePatient(patient).subscribe(
      (response: Patient) => {
        console.log(response);
        this.getPatients();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeletePatient(id: number): void {
    this.patientService.deletePatient(id).subscribe(
      (response: void) => {
        console.log(response);
        this.getPatients();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchPatients(key: string): void {
    console.log(key);
    const results: Patient[] = [];
    for (const patient of this.patients) {
      if (patient.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || patient.insProvider.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || patient.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || patient.phoneNumber.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || patient.address.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || patient.bloodType.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || patient.affliction.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || patient.treatment.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || patient.inHospital.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || patient.age.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || patient.sex.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || patient.birthdate.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(patient);
      }
    }
    this.patients = results;
    if (results.length === 0 || !key) {
      this.getPatients();
    }
  }

  public onOpenModal(patient: Patient, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addPatientModal');
    }
    if (mode === 'edit') {
      this.editPatient = patient;
      button.setAttribute('data-target', '#updatePatientModal');
    }
    if (mode === 'delete') {
      this.deletePatient = patient;
      button.setAttribute('data-target', '#deletePatientModal');
    }
    container.appendChild(button);
    button.click();
  }
}
