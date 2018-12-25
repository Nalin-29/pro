import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WeeklyUserReportComponent } from './weekly-user-report.component';

describe('WeeklyUserReportComponent', () => {
  let component: WeeklyUserReportComponent;
  let fixture: ComponentFixture<WeeklyUserReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WeeklyUserReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WeeklyUserReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
