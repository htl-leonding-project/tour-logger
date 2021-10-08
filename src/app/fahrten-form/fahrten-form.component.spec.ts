import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FahrtenFormComponent } from './fahrten-form.component';

describe('FahrtenFormComponent', () => {
  let component: FahrtenFormComponent;
  let fixture: ComponentFixture<FahrtenFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FahrtenFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FahrtenFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
