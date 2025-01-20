import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModuleadminComponent } from './moduleadmin.component';

describe('ModuleadminComponent', () => {
  let component: ModuleadminComponent;
  let fixture: ComponentFixture<ModuleadminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModuleadminComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ModuleadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
