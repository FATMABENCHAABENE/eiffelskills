import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeachershowevalComponent } from './teachershoweval.component';

describe('TeachershowevalComponent', () => {
  let component: TeachershowevalComponent;
  let fixture: ComponentFixture<TeachershowevalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TeachershowevalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TeachershowevalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
