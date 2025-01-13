import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MessageFormComponent } from './messageform.component';

describe('messageformComponent', () => {
  let component: MessageFormComponent;
  let fixture: ComponentFixture<MessageFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MessageFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MessageFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
