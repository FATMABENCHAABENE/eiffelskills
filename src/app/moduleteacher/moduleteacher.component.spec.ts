import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModuleteacherComponent } from './moduleteacher.component';

describe('ModuleteacherComponent', () => {
  let component: ModuleteacherComponent;
  let fixture: ComponentFixture<ModuleteacherComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModuleteacherComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ModuleteacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
