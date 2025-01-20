import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModulestudentComponent } from './modulestudent.component';

describe('ModulestudentComponent', () => {
  let component: ModulestudentComponent;
  let fixture: ComponentFixture<ModulestudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModulestudentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ModulestudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
