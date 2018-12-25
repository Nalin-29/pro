import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieFooterComponent } from './movie-footer.component';

describe('MovieFooterComponent', () => {
  let component: MovieFooterComponent;
  let fixture: ComponentFixture<MovieFooterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieFooterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
