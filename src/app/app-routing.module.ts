import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SuccessPageComponent } from './success-page/success-page.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';



const routes: Routes = [
  {path: 'success-page', component: SuccessPageComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'login', component: LoginComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
