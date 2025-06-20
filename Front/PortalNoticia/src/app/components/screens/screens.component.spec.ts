import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScreensComponent } from './screens.component';

describe('ScreensComponent', () => {
  let component: ScreensComponent;
  let fixture: ComponentFixture<ScreensComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ScreensComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScreensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
