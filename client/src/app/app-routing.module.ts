import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminAddMovieComponent } from './admin-add-movie/admin-add-movie.component';
import { AdminEditMovieComponent } from './admin-edit-movie/admin-edit-movie.component';
import { AdminViewMovieComponent } from './admin-view-movie/admin-view-movie.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { HomeComponent } from './home/home.component';
import { FavouritesComponent } from './favourites/favourites.component';
import { SearchHistoryComponent } from './search-history/search-history.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { PlaylistComponent } from './playlist/playlist.component';
import { ReportComponent } from './report/report.component';
import { WeeklyReportComponent } from './weekly-report/weekly-report.component';
import { WeeklyUserReportComponent } from './weekly-user-report/weekly-user-report.component';

const routes: Routes = [
  {path: 'adminhome', component: AdminHomeComponent},
  {path: 'adminaddmovie', component: AdminAddMovieComponent},
  {path: 'admineditmovie', component: AdminEditMovieComponent},
  {path: 'adminviewmovie', component: AdminViewMovieComponent},
  {path: 'favourite', component: FavouritesComponent},
  {path: 'searchhistory', component: SearchHistoryComponent},
  {path: '', component: WelcomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent },
  {path: 'signup', component: SignupComponent},
  {path: 'welcome', component: WelcomeComponent},
  {path: 'playlist', component: PlaylistComponent},
  {path: 'report', component: ReportComponent},
  {path: 'weeklyreport', component: WeeklyReportComponent},
  {path: 'weeklyuserreport', component: WeeklyUserReportComponent},
  {path: '**', component: WelcomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
