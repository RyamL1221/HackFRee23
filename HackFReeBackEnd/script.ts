import{ Patient } from './patient';
@Component({
  selector:'app-root',
  templateURL:'/pat.html',
  styleUrls:['./style.css']
})
export class AppComponent{
  public patients: Patients[];
  constructor(private patientService: employeeServer()){
    
  }
  public getPatients(): void{
    this.patientService.getPatients().subscribe(
      (response: employee[]) => {
        this.patients = response;
      },
      (error: HttpErrorResponse){
        alert(error.message);
      }
    )
  }
}
public onAddPatient(addForm: NgForm): void{
  document.getElementById('add-patient-form').click();
  this.employeeService.addPatient(addForm.value).subscribe(
    (response:Employee)=> {
      console.log(response);
      this.getEmployees();
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  )
}