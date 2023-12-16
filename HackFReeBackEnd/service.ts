import {Patient} from './patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService{
  private apiServerURL = '';
  constructor(private http: HttpClient){}

  public getPatients(): Observable<Patient[]>{
    return this.http.get<any>(`${this.apiServerURL}/patient/all`);
  }
  public addPatient(patient: Patient): Observable<Patient>{
    return this.http.post<Patient>(`${this.apiServerURL}/patient/add`, patient);
  }
}